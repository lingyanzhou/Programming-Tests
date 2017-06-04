package lzhou.programmingtest.leetcode.test591;

import java.util.*;

import java.util.stream.*;

public class Solution {
    public boolean isValid(String code) {
    	State state = new Begin();
        for (int i=0; i<code.length();++i) {
            char c = code.charAt(i);
            state = state.accept(c);
            System.out.println(state.getClass().getName());
            if (!state.isValid()) {
            	return false;
            }
        }
        return state.isEnd();
    }
}

interface State {
    public State accept(char c);
    public boolean isValid();
    public boolean isEnd();
}

class Begin implements State {
    public State accept(char c) {
        if (c=='<') {
            return new ReadingTag(new Stack<String>());
        } else {
            return new Invalid();
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}
class End implements State {
    public State accept(char c) {
        return new Invalid();
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return true;}
}


class Invalid implements State {
    public State accept(char c) {
        return this;
    }
    public boolean isValid(){return false;}
    public boolean isEnd(){return false;}
}
class ReadingTag implements State {
    int i = 0;
    String tag = "";
    Stack<String> tags;
	public ReadingTag(Stack<String> tags) {
		this.tags = tags;
		i=0;
	}
    public State accept(char c) {
        if (Character.isUpperCase(c)) {
            i+=1;
            tag = tag+c;
            if (i==10) {
                return new  Invalid();
            }
            return this;
        } else if (c=='>') {
        	if (i>0) {
            	tags.push(tag);
                return new ReadingText(tags);
        	} else {
        		return new Invalid();
        	}
        } else {
            return new Invalid();
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}
class ReadingEndTag implements State {
    int i = 0;
    String tag = "";
    Stack<String> tags;
    String toMatch;
	public ReadingEndTag(Stack<String> tags) {
		this.tags = tags;
		i=0;
		toMatch = "/"+tags.pop()+">";
	}
    public State accept(char c) {
        if (i<toMatch.length()) {
            if (c==toMatch.charAt(i)) {
            	i+=1;
            	if (i==toMatch.length()) {
            		if (tags.isEmpty()) {
            			return new End();
            		} else {
            			return new ReadingText(tags);
            		}
            	} else {
            		return this;
            	}
            } else {
            	return new Invalid();
            }
        } else {
            return new Invalid();
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}
class ReadingText implements State {
    Stack<String> tags;
	public ReadingText(Stack<String> tags) {
		this.tags = tags;
	}
    public State accept(char c) {
        if (c=='<') {
            return new ReadingLtSymbol(tags);
        } else {
            return this;
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}
class ReadingLtSymbol implements State {
    Stack<String> tags;
	public ReadingLtSymbol(Stack<String> tags) {
		this.tags = tags;
	}
    public State accept(char c) {
        if (Character.isUpperCase(c)) {
            State state = new ReadingTag(tags);
            return state.accept(c);
        } else if (c=='!') {
            State state = new ReadingCdataTag(tags);
            return state.accept(c);
        } else if (c=='/') {
            State state = new ReadingEndTag(tags);
            return state.accept(c);
        } else {
            return new Invalid();
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}

class ReadingCdataTag implements State {
    Stack<String> tags;
	public ReadingCdataTag(Stack<String> tags) {
		this.tags = tags;
	}
	static final String CDATA_TAG = "![CDATA[";
	int i = 0;
	public State accept(char c) {
        if (i<CDATA_TAG.length()) {
        	if (c==CDATA_TAG.charAt(i)) {
        		i+=1;
        		return this;
        	} else {
        		return new Invalid();
        	}
        } else {
        	return new ReadingCdataContent(tags).accept(c);
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}

class ReadingCdataEndTag implements State {
	static final String CDATA_END_TAG = "]]>";
	int i = 0;
    Stack<String> tags;
	public ReadingCdataEndTag(Stack<String> tags) {
		this.tags = tags;
	}
	public State accept(char c) {
		if (i<CDATA_END_TAG.length()) {
        	if (c==CDATA_END_TAG.charAt(i)) {
        		i+=1;
        		return this;
        	} else {
        		return new ReadingCdataContent(tags).accept(c);
        	}
        } else {
        	return new ReadingText(tags).accept(c);
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}
    
class ReadingCdataContent implements State {

    Stack<String> tags;
	public ReadingCdataContent(Stack<String> tags) {
		this.tags = tags;
	}
	public State accept(char c) {
        if (c==']') {
            return new ReadingCdataEndTag(tags).accept(c);
        } else {
            return this;
        }
    }
    public boolean isValid(){return true;}
    public boolean isEnd(){return false;}
}

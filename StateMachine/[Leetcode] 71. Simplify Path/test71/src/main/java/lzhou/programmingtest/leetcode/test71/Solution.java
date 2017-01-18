package lzhou.programmingtest.leetcode.test71;

import java.util.*;

public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        Stack<String> pathStack = new Stack<String>();
        
        int folderStart = 0;
        ParseState state = ParseState.Begin;
        for (int i=0; i<path.length(); ++i) {
            char c = path.charAt(i);
            switch (c) {
                case '.':
                    switch (state) {
                        case ReadingSlash:
                            folderStart = i;
                            state = ParseState.ReadingDot;
                            break;
                        case ReadingDot:
                            state = ParseState.ReadingDotDot;
                            break;
                        case ReadingDotDot:
                            state = ParseState.ReadingPath;
                            break;
                        default:
                            break;
                    }
                    break;
                case '/':
                    switch (state) {
                        case ReadingDotDot:
                            state = ParseState.ReadingSlash;
                            if (!pathStack.isEmpty()) {
                                pathStack.pop();
                            }
                            break;
                        case ReadingDot:
                            state = ParseState.ReadingSlash;
                            break;
                        case ReadingPath:
                            String tmp = path.substring(folderStart, i);
                            pathStack.push(tmp);
                            state = ParseState.ReadingSlash;
                            break;
                        case Begin:
                            state = ParseState.ReadingSlash;
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    switch (state) {
                        case ReadingSlash:
                            folderStart = i;
                            state = ParseState.ReadingPath;
                            break;
                        case ReadingDot:
                            state = ParseState.ReadingPath;
                            break;
                        case ReadingDotDot:
                            state = ParseState.ReadingPath;
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        switch (state) {
            case ReadingDotDot:
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
                break;
            case ReadingPath:
                pathStack.push(path.substring(folderStart, path.length()));
                break;
            default:
                break;
        }
        
        if (pathStack.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        while (pathStack.size()>0) {
            stack.push(pathStack.pop());
        }
        while (stack.size()>0) {
            sb.append('/');
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}

enum ParseState {
    Begin,
    ReadingSlash,
    ReadingPath,
    ReadingDot,
    ReadingDotDot
}

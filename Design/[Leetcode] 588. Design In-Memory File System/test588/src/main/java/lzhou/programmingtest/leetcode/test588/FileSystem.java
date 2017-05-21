package lzhou.programmingtest.leetcode.test588;

import java.util.*;

import java.util.stream.*;

public class FileSystem {
    Directory root;
    public FileSystem() {
        root = new Directory();
    }
    
    public List<String> ls(String path) {
        assert(path.startsWith("/"));
        return root.ls(path.substring(1));
    }
    
    public void mkdir(String path) {
        assert(path.startsWith("/"));
        root.mkdir(path.substring(1));
    }
    
    public void addContentToFile(String filePath, String content) {
        assert(filePath.startsWith("/"));
        root.addContentToFile(filePath.substring(1), content);
    }
    
    public String readContentFromFile(String filePath) {
        assert(filePath.startsWith("/"));
        return root.readContentFromFile(filePath.substring(1));
    }
}

class Directory {
    Map<String, Directory> childrenDirs = new HashMap<String, Directory>();
    Map<String, String> childrenFiles = new HashMap<String, String>();
    
    List<String> ls(String path) {
        if (path.length()==0) {
            List<String> list = new ArrayList<String>(childrenDirs.keySet());
            list.addAll(childrenFiles.keySet());
            Collections.sort(list);
            return list;
        } else {
            int tmp = path.indexOf("/");
            if (tmp==-1) {
                if (childrenFiles.containsKey(path)) {
                    return Arrays.asList(path);
                } else if (childrenDirs.containsKey(path)) {
                    return childrenDirs.get(path).ls("");
                } else {
                    return Collections.<String>emptyList();
                }
            } else {
                String subdir = path.substring(0, tmp);
                String remain = path.substring(tmp+1);
                if (childrenDirs.containsKey(subdir)) {
                    return childrenDirs.get(subdir).ls(remain);
                } else {
                    return Collections.<String>emptyList();
                }
            }
        }
    }
    
    public void mkdir(String path) {
        if (path.length()==0) {
            return;
        } else {
            int tmp = path.indexOf("/");
            if (tmp==-1) {
                if (childrenDirs.containsKey(path)) {
                    return;
                } else {
                    childrenDirs.put(path, new Directory());
                    return;
                }
            } else {
                String subdir = path.substring(0, tmp);
                String remain = path.substring(tmp+1);
                if (childrenDirs.containsKey(subdir)) {
                    childrenDirs.get(subdir).mkdir(remain);
                } else {
                    Directory nextDir = new Directory();
                    childrenDirs.put(subdir, nextDir);
                    nextDir.mkdir(remain);
                }
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        if (filePath.length()==0) {
            return;
        } else {
            int tmp = filePath.indexOf("/");
            if (tmp==-1) {
                if (childrenFiles.containsKey(filePath)) {
                    childrenFiles.put(filePath, childrenFiles.get(filePath)+content);
                    return;
                } else {
                    childrenFiles.put(filePath, content);
                    return;
                }
            } else {
                String subdir = filePath.substring(0, tmp);
                String remain = filePath.substring(tmp+1);
                if (childrenDirs.containsKey(subdir)) {
                    childrenDirs.get(subdir).addContentToFile(remain, content);
                    return;
                } else {
                    return;
                }
            }
        }
    }
    
    public String readContentFromFile(String filePath) {
        if (filePath.length()==0) {
            return "";
        } else {
            int tmp = filePath.indexOf("/");
            if (tmp==-1) {
                if (childrenFiles.containsKey(filePath)) {
                    return childrenFiles.get(filePath);
                } else {
                    return "";
                }
            } else {
                String subdir = filePath.substring(0, tmp);
                String remain = filePath.substring(tmp+1);
                if (childrenDirs.containsKey(subdir)) {
                    return childrenDirs.get(subdir).readContentFromFile(remain);
                } else {
                    return "";
                }
            }
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

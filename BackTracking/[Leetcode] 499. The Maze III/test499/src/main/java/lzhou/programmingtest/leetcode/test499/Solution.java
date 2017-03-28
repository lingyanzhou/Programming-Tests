package lzhou.programmingtest.leetcode.test499;

import java.util.*;

public class Solution 
{
    private static final int PATH=0;
    private static final int WALL=1;
    private static final int HOLE=3;
    private static final int TESTED=2;
    
    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        assert maze[start[0]][start[1]]==0 && maze[destination[0]][destination[1]]==0;
        if (maze.length==0 || maze[0].length==0) {
            return "impossible";
        }
        GraphNode[][] nodes= new GraphNode[maze.length][maze[0].length];
        for (int i=0; i<maze.length; ++i) {
            for (int j=0; j<maze[i].length; ++j) {
                nodes[i][j] = new GraphNode(i, j);
            }
        }
        int[][] mazeCopy= new int[maze.length][maze[0].length];
        for (int i=0; i<maze.length; ++i) {
            for (int j=0; j<maze[i].length; ++j) {
                mazeCopy[i][j] = maze[i][j];
            }
        }
        
        mazeCopy[destination[0]][destination[1]]=HOLE;
        nodes[destination[0]][destination[1]].end=true;
        linkLeftNodes(mazeCopy, nodes);
        linkRightNodes(mazeCopy, nodes);
        linkUpNodes(mazeCopy, nodes);
        linkDownNodes(mazeCopy, nodes);

        GraphNode current = nodes[start[0]][start[1]];
        PriorityQueue<GraphNode> queue = new PriorityQueue<GraphNode>();

        queue.offer(current);

        while (queue.size()>0) {
            GraphNode cur = queue.poll();
            System.out.println("x="+cur.x+", y="+cur.y+", moves="+cur.moves+", cost="+cur.cost);
            if (cur.end) {
                return cur.moves;
            }

            if (mazeCopy[cur.x][cur.y]==TESTED) {
                continue;
            }
            mazeCopy[cur.x][cur.y]=TESTED;


            if (cur.down!=null && mazeCopy[cur.down.x][cur.down.y]!=TESTED) {
                cur.down.cost = cur.cost + cur.distance(cur.down);
                cur.down.moves=cur.moves+"d";
                queue.offer(cur.down);
            }
            
            if (cur.left!=null && mazeCopy[cur.left.x][cur.left.y]!=TESTED) {
                cur.left.cost = cur.cost + cur.distance(cur.left);
                cur.left.moves=cur.moves+"l";
                queue.offer(cur.left);
            }
            
            if (cur.right!=null && mazeCopy[cur.right.x][cur.right.y]!=TESTED) {
                cur.right.cost = cur.cost + cur.distance(cur.right);
                cur.right.moves=cur.moves+"r";
                queue.offer(cur.right);
            }
            
            if (cur.up!=null && mazeCopy[cur.up.x][cur.up.y]!=TESTED) {
                cur.up.cost = cur.cost + cur.distance(cur.up);
                cur.up.moves=cur.moves+"u";
                queue.offer(cur.up);
            }
        }
        
        return "impossible";
    }

    private void linkLeftNodes(int[][] maze, GraphNode[][] nodes) {
        for (int i=0; i<maze.length; ++i) {
            GraphNode left = null;
            for (int j=0; j<maze[i].length; ++j) {
                if (maze[i][j]==WALL) {
                    left = null;
                } else if (maze[i][j]==HOLE) {
                    left = nodes[i][j];
                } else if (maze[i][j]==PATH && left==null) {
                    left = nodes[i][j];
                } else { //(maze[i][j]==PATH && left!=null)
                    nodes[i][j].left = left;
                }
            }
        }
    }

    private void linkRightNodes(int[][] maze, GraphNode[][] nodes) {
        for (int i=0; i<maze.length; ++i) {
            GraphNode right = null;
            for (int j=maze[i].length-1; j>=0; --j) {
                if (maze[i][j]==WALL) {
                    right = null;
                } else if (maze[i][j]==HOLE) {
                    right = nodes[i][j];
                } else if (maze[i][j]==PATH && right==null) {
                    right = nodes[i][j];
                } else { //(maze[i][j]==PATH && right!=null)
                    nodes[i][j].right = right;
                }
            }
        }
    }

    private void linkUpNodes(int[][] maze, GraphNode[][] nodes) {
        for (int j=0; j<maze[0].length; ++j) {
            GraphNode up = null;
            for (int i=0; i<maze.length; ++i) {
                if (maze[i][j]==WALL) {
                    up = null;
                } else if (maze[i][j]==HOLE) {
                    up = nodes[i][j];
                } else if (maze[i][j]==PATH && up==null) {
                    up = nodes[i][j];
                } else { //(maze[i][j]==PATH && up!=null)
                    nodes[i][j].up = up;
                }
            }
        }
    }

    private void linkDownNodes(int[][] maze, GraphNode[][] nodes) {
        for (int j=0; j<maze[0].length; ++j) {
            GraphNode down = null;
            for (int i=maze.length-1; i>=0; --i) {
                if (maze[i][j]==WALL) {
                    down = null;
                } else if (maze[i][j]==HOLE) {
                    down = nodes[i][j];
                } else if (maze[i][j]==PATH && down==null) {
                    down = nodes[i][j];
                } else { //(maze[i][j]==PATH && down!=null)
                    nodes[i][j].down = down;
                }
            }
        }
    }

}

class PathInfo {
    StringBuffer moves;
    boolean found;
    PathInfo(boolean found, StringBuffer moves) {
        this.found = found;
        this.moves = moves;
    }
}

class GraphNode implements Comparable<GraphNode> { 
    GraphNode left;
    GraphNode right;
    GraphNode up;
    GraphNode down;
    boolean end;
    int x;
    int y;
    int cost;
    String moves;
    
    GraphNode(int x, int y) {
        this.x = x;
        this.y = y;
        end=false;
        left = null;
        right = null;
        up = null;
        down = null;
        cost = 0;
        moves = "";
    }

    int distance(GraphNode n2) {
        return Math.abs(y-n2.y)+Math.abs(x-n2.x);
    }

    public int compareTo(GraphNode n2) {
        int ret = Integer.compare(cost, n2.cost);
        if (ret==0) {
            ret = moves.compareTo(n2.moves);
        }
        return ret;
    }
}

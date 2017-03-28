package lzhou.programmingtest.leetcode.test490;

import java.util.*;

public class Solution 
{
    private static final int PATH=0;
    private static final int WALL=1;
    private static final int TESTED=2;
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        assert maze[start[0]][start[1]]==0 && maze[destination[0]][destination[1]]==0;
        if (maze.length==0 || maze[0].length==0) {
            return false;
        }
        int[][] mazeCopy= new int[maze.length][maze[0].length];
        for (int i=0; i<maze.length; ++i) {
            for (int j=0; j<maze[i].length; ++j) {
                mazeCopy[i][j] = maze[i][j];
            }
        }
        return hasPathHelper(mazeCopy, start, destination);
    }

    private boolean hasPathHelper(int[][] maze, int[] start, int[] destination) {
        if (maze[start[0]][start[1]]==TESTED) {
            return false;
        }
        if (start[0]==destination[0] && start[1]==destination[1]) {
            return true;
        }

        maze[start[0]][start[1]]=TESTED;

        int[] left = moveLeft(maze, start);
        if (hasPathHelper(maze, left, destination)) {
            return true;
        }
        int[] right = moveRight(maze, start);
        if (hasPathHelper(maze, right, destination)) {
            return true;
        }
        int[] up = moveUp(maze, start);
        if (hasPathHelper(maze, up, destination)) {
            return true;
        }
        int[] down = moveDown(maze, start);
        if (hasPathHelper(maze, down, destination)) {
            return true;
        }
        return false;
    }

    private int[] moveLeft(int[][] maze, int[] start) {
        int[] ret = new int[]{start[0], start[1]};
        while (ret[1]>0 && maze[ret[0]][ret[1]-1]!=WALL) {
            ret[1]-=1;
        }
        return ret;
    }

    private int[] moveRight(int[][] maze, int[] start) {
        int[] ret = new int[]{start[0], start[1]};
        while (ret[1]<maze[0].length-1 && maze[ret[0]][ret[1]+1]!=WALL) {
            ret[1]+=1;
        }
        return ret;
    }

    private int[] moveUp(int[][] maze, int[] start) {
        int[] ret = new int[]{start[0], start[1]};
        while (ret[0]>0 && maze[ret[0]-1][ret[1]]!=WALL) {
            ret[0]-=1;
        }
        return ret;
    }

    private int[] moveDown(int[][] maze, int[] start) {
        int[] ret = new int[]{start[0], start[1]};
        while (ret[0]<maze.length-1 && maze[ret[0]+1][ret[1]]!=WALL) {
            ret[0]+=1;
        }
        return ret;
    }
}

#Backtracking solution

1. Keep 3 maps, one for column, one for diagnal, one for reverse diagnal. They keep track of which row, column, diagnal and reverse diagnal line are occupied. (Row map is not needed because we move row by row.)
2. We one queen in each row. For each row, we try each column. if we reach the end of the row, we backtrack.
3. If all queens are used, it is a possible way. We increment the counter, and backtrack.

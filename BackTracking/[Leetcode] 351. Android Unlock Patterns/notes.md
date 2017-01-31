#DFS solution

1. Define `dfs(start, m, n)` as the number of patterns with min/max length of `m`/`n` starting from `start`
2. Because of symmetry, `numberOfPatterns(m, n)=4*dfs(0, m, n)+4*dfs(1, m, n)+dfs(4, m, n)`
3. When in DFS, try each key if the key is not the current key, if the key is not used, and if there is a key in between that is not used.

#UnionFind solution

1. Any graph without a loop is a tree, or forest.
2. Use BFS and UnionFind to detect circles. If a node has two or adjacent nodes belongbeling to the same union set, a loop is detected.
3. If no loop is detected and all nodes belong to the same union set, then it is a valid tree.

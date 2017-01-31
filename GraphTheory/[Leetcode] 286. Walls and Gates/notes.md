#BSF solution

1. Put all points with value 0s in a queue
2. While the queue is not empty, pop its head, do the following:
2.1. Find the adjacent empty rooms of the head that have not been assigned a value.
2.2. Assign the distance. Push the rooms to the queue.

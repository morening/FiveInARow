## Current Implementation
```
1. Human hand first and then Computer make decision to move based on MiniMax algorithm
2. Create game tree within 3 depth and evaluate the score(= computer's score - human's score)
3. By Alpha-Beta Pruning, it could spend less time to make decision
4. Add Logger to record useful information in order to debug easily
```

## Promotion In Future
```
As gaming goes on, it will need more nodes to explore larger space.
So it will lead to much slower computation and more memory.
It will occur OOM exception when creating game tree within 5 depth.
I will make much more effort to protmote it. 
```
## What I have tried?
### Use duplicated situation
```
1. Same board will be created, so there will be some duplicated situations to be predicated.
2. Add function to check if it is duplicated. If A and B are same, B should not be created and explore any more.
3. When populating, B's value could be A's.
4. However, there are some problems. There are some bugs because of evaluating sequence and Alpha-Beta Pruning. So I think it is not a good opportunity to do it.
```

### Re-use Game tree in next turn
```
1. Make decision in every turn, it have to take plenty of times and more memories to build the game tree.
2. If could re-use it, I think it may speed up make decision with 5 depth.
3. However, testing result shows that it is not useful in make decision with 5 depth. It is still slow...And what is worse is that it will make "make decision with 3 depth" much slower.
```

## What I will try?
```
Sorting before evaluating, it could make use of Alpha-Beta Pruning. I think it may be more effective.
```

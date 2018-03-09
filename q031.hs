getMods [] = []
getMods (x:xs) = [200 `mod` x] ++ getMods xs
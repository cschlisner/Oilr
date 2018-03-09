fact [] = 1
fact [x] = x
fact (x:xs) = x * fact xs

dig 0 = []
dig x =  (dig (x `div` 10)) ++ [x `mod` 10]

ans x = sum ( dig (fact [1..x]))
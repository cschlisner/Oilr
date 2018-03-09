
getDigs 0 = []
getDigs x = getDigs (x `div` 10) ++ [x `mod` 10]

factsheet x
    | (x == 2) = 2
    | (x == 3) = 6
    | (x == 4) = 24
    | (x == 5) = 120
    | (x == 6) = 720
    | (x == 7) = 5040
    | (x == 8) = 40320
    | (x == 9) = 362880
    | otherwise = 1


fact x 
    | (x <= 1) = 1
    | otherwise = x * (fact (x-1))

ye x = (sum ([factsheet z | z <- (getDigs x)]))

ans q x = sum ([y | y <- [q..x], ye y == y])


main :: IO ()
main = print (ans 145 (ye 9999999))

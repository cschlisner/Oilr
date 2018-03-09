-- does the thing
getdiff x y a b 
    | (a == x) = [y, b]
    | (b == x) = [y, a]
    | (a == y) = [x, b]
    | (b == y) = [x, a]
    | otherwise = [-1, -1]

-- concats numbers
concatnum x y 
            | y > 1 = (x * ( 10 ^ ( ceiling (logBase 10 y) ) ) + y)
            | y == 1 = (x * ( 10 ) + y)
            | otherwise = x * 10

-- returns false if the 'numerator' and 'denominator' do not share a digit
-- else returns whether the given fraction is equal to itself without the shared digit
equalsDiff x y a b 
            | ((head (getdiff x y a b)) < 0) = False
            | otherwise = concatnum x y / concatnum a b == ( (head (getdiff x y a b)) / (last (getdiff x y a b)) )

multi [] = [1,1]
multi [[x]] = [x]
multi (x:xs) = [head x * head (multi xs), last x * last (multi xs)]

uniques = [[concatnum x y, concatnum a b] | x <- [1..9], y <- [1..9], a <- [1..9], b <- [1..9], concatnum x y < concatnum a b, equalsDiff x y a b]

ans = last (multi uniques) / head (multi uniques)

main :: IO ()
main = print ans
import Data.List

meme = [1..6]

outerNodes :: [Integer] -> [[Integer]]
outerNodes range = [sort [na,nb,nc] | na <- range, 
                                       nb <- delete na range, 
                                       nc <- delete nb (delete na range)] 
                                       --nd <- delete nc (delete nb (delete na range)), 
                                       --ne <- delete nd (delete nc (delete nb (delete na range))),
                                   --   (na == 10 || nb == 10 || nc == 10 || nd == 10 || ne == 10)]

innerNodes :: [Integer] -> [Integer] -> [[Integer]]
innerNodes range xs = [[na,nb,nc] | na <- (range \\ xs), 
                                          nb <- delete na (range \\ xs), 
                                          nc <- delete nb (delete na (range \\ xs))] 
                                          --nd <- delete nc (delete nb (delete na (range \\ xs))), 
                                          --ne <- delete nd (delete nc (delete nb (delete na (range \\ xs))))]

magicRing :: [Integer] -> [Integer] -> [[Integer]]
magicRing o i = let i' = i ++ [head i]
                in [[o !! x , i' !! x, i' !! (x+1)] | x <- [0..(length o)-1]]
 
isValidRing :: [[Integer]] -> Integer -> Bool
isValidRing r k
                | (length r == 1) = (sum (head r)) == k
                | (k == 0 || (sum (head r)) == k) = isValidRing (tail r) (sum (head r))
                | otherwise = False

getRings :: [[Integer]] -> [([Integer], [[Integer]])]
getRings ns = [(n, innerNodes meme n) | n <- ns]

getMRings = let r = getRings (outerNodes meme)
            in [(magicRing (fst ring) (inn)) | ring <- r, inn <- (snd ring)]



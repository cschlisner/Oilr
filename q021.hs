sumdivs x = sum [y | y<-[1..(x `div` 02)+1], x `mod` y == 0]
amicable x = (x == sumdivs (y) && x /= y) where y = sumdivs x
ans x = sum [y | y<-[1..x], amicable y]
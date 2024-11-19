--  Folds and scans

list_product :: [Integer] -> Integer
list_product = foldr (*) 1

list_any :: [Bool] -> Bool
list_any = foldr (||) False

product_of_evens :: [Integer] -> Integer
product_of_evens = foldr
    (\x acc ->
        if mod x 2 == 0
            then acc * x
            else acc
    ) 1

lt10 :: [Integer] -> Integer
lt10 = foldr
    (\x acc ->
        if x < 10
            then acc + 1
            else acc
    ) 0 

smalls :: String -> String
smalls = foldr
    (\s acc ->
        if s >= 'a' && s <= 'z'
            then s : acc
            else acc
    ) ""

sum_evens_odds :: [Integer] -> (Integer, Integer)
sum_evens_odds = foldr
    (\x (a, b) ->
        if mod x 2 == 0
            then (a + x, b)
            else (a, b + x)
    ) (0, 0)

--  takeWhile and dropWhile

leading_caps :: String -> String
leading_caps = takeWhile (\s -> s >='A' && s <='Z')

drop_caps :: String -> String
drop_caps    = dropWhile (\s -> s >='A' && s <='Z')

split_on :: Char -> String -> (String, String)
split_on c string = (
    takeWhile (/=c) string,
    tail $
    dropWhile (/=c) string
    )

from_csv :: String -> [String]
from_csv s
    | s      == []  = []
    | head s == ',' = from_csv (tail s)
    | otherwise     = takeWhile (/= ',') s : from_csv (dropWhile (/= ',') s)

--  zipWith

mul_lists :: [Integer] -> [Integer] -> [Integer]
mul_lists = zipWith (*)

and_lists :: [Bool] -> [Bool] -> [Bool]
and_lists = zipWith (&&)

keep_or_zero :: [Int] -> [Bool] -> [Int]
keep_or_zero = zipWith (\x y -> if y then x else 0)

--is_palindrome :: String -> Bool
is_palindrome list = and $ zipWith (\x y -> if x == y
    then True
    else False
    ) list (reverse list)

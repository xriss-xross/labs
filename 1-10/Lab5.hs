plus_ten :: Integer -> Integer
plus_ten = (10 +)

is_twenty :: Integer -> Bool
is_twenty = (==20)

three_power :: Double -> Double
three_power = (3**)

power_three :: Double -> Double
power_three = (**3)

take_four :: [Int] -> [Int]
take_four = (take 4)

triple :: [Int] -> [Int]
triple = (map (3*))

list_to_str :: [Int] -> [[Char]]
list_to_str = map show

second_char :: [String] -> [Char]
second_char = map (!! 1)

add_pairs :: [(Int, Int)] -> [Int]
add_pairs = map (\(a, b) -> a + b)

triple_list_list :: [[Int]] -> [[Int]]
triple_list_list = map (map (*3))

only_odds :: [Int] -> [Int]
only_odds = filter odd

vowels :: String -> String
vowels = filter (\x -> x `elem` "aeiou")

between :: Int -> Int -> [Int] -> [Int]
between a b list = filter (\x -> x > a && x < b) list

ordered :: [(Int, Int)] -> [(Int, Int)]
ordered = filter (\(a, b) -> a > b)

singletons :: [[Int]] -> [[Int]]
singletons = filter (\x -> (length x) == 1)

only_odds_list :: [[Int]] -> [[Int]]
only_odds_list = map (filter odd)

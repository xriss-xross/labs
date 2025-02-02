char_to_int :: Char -> Integer
char_to_int c
    | c == '0' = 0
    | c == '1' = 1
    | c == '2' = 2
    | c == '3' = 3
    | c == '4' = 4
    | c == '5' = 5
    | c == '6' = 6
    | c == '7' = 7
    | c == '8' = 8
    | c == '9' = 9

int_to_char :: Integer -> Char
int_to_char n
    | n == 0 = '0'
    | n == 1 = '1'
    | n == 2 = '2'
    | n == 3 = '3'
    | n == 4 = '4'
    | n == 5 = '5'
    | n == 6 = '6'
    | n == 7 = '7'
    | n == 8 = '8'
    | n == 9 = '9'

check_int :: Char -> Bool
check_int c
    | c == '0' = True
    | c == '1' = True
    | c == '2' = True
    | c == '3' = True
    | c == '4' = True
    | c == '5' = True
    | c == '6' = True
    | c == '7' = True
    | c == '8' = True
    | c == '9' = True
    | otherwise = False

complex_str_to_int :: [Char] -> Integer -> Integer
complex_str_to_int s i
    | s == [] = 0
    | otherwise = (char_to_int (head s') * 10 ^ i) + (complex_str_to_int (init s) (i+1))
        where s' = reverse s

complex_int_to_str_r :: Integer -> Integer -> [Char]
complex_int_to_str_r n i
    | n == 0 = ""
    | otherwise = complex_int_to_str_r (n - n') (i+1) ++ [int_to_char d]
        where
            n' = mod n (10^(i+1))
            d = div n' (10^(i))

repeat_char :: Char -> Integer -> [Char]
repeat_char c n
    | n == 0    = []
    | otherwise = [c] ++ repeat_char c (n-1)

length_char :: Char -> [Char] -> Integer
length_char _ [] = 0
length_char c (x:xs)
    | x /= c = 0
    | otherwise = 1 + length_char c xs

get_number :: [Char] -> [Char]
get_number [] = []
get_number (x:xs)
    | check_int x == False = []
    | otherwise         = x : get_number xs

drop_char :: Char -> [Char] -> [Char]
drop_char _ [] = []
drop_char c (x:xs)
    | x /= c = x:xs
    | otherwise = drop_char c xs

drop_complex_int :: [Char] -> [Char]
drop_complex_int [] = []
drop_complex_int (x:xs)
    | check_int x == False = x:xs
    | otherwise = drop_complex_int xs

decode :: [Char] -> [Char]
decode []     = []
decode (x:xs) = repeat_char x n ++ decode s
    where
        n = char_to_int(head (xs))
        s = (tail (xs))

encode :: [Char] -> [Char]
encode []     = []
encode (x:xs) = ([x] ++ [int_to_char l]) ++ encode (drop_char x xs)
    where
        l = length_char x (x:xs)

complex_decode :: [Char] -> [Char]
complex_decode []     = []
complex_decode (x:xs) = repeat_char x n ++ complex_decode s
    where
        n = complex_str_to_int(get_number xs) 0
        s = drop_complex_int xs

complex_encode :: [Char] -> [Char]
complex_encode [] = []
complex_encode (x:xs) = ([x] ++ complex_int_to_str_r l 0) ++ (complex_encode (drop_char x xs))
    where
        l = length_char x (x : xs)

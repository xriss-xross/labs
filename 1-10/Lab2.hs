square_and_cube x = (x*x, x*x*x)

add_tuple (a, b) = a + b

first (x, y) = fst(x, y)
second (x, y) = snd(x, y)

swap (x, y) = (y, x)

two_to_three (a, b) c = (a, b, c)

head_squared list = head(list)^2

third list = list !! 2

second_tail list = tail(tail(list))

third_head list = head(tail(tail(list)))

first_plus_last list = head list  + last list

prepend_two list a b = a : b : list

two_lengths list1 list2 = length list1 + length list2

make_palindrome list = list ++ reverse list

sum_and_product list = (sum list, product list)

four_through_six list = take 3 (drop 3 list)

both_in list x y = if elem x list && elem y list then True
                    else False

only_odds list = [x | x <- list, odd x]

between a b list = [x | x <- list, a < x, x < b]

number_of_es string = sum [1 | x <- string, x == 'e']

proper_fizzbuzz = [if mod i 3 == 0 && mod i 5 == 0 then "fizzbuzz"
                    else if mod i 3 == 0 then "fizz"
                    else if mod i 5 == 0 then "buzz"
                    else show i | i <- [1..]]

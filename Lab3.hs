mult13 1 = 13
mult13 n = 13 + mult13 (n-1)

pow3 1 = 3
pow3 n = 3 * pow3 (n-1)

odd_sum n
    | 1 <- n       = 1
    | 0 <- mod 2 n = odd_sum (n-1) 
    | otherwise    = n + odd_sum (n-2)

lucas 0 = 2
lucas 1 = 1
lucas n = lucas(n-1) + lucas(n-2)

half_sum [] = 0
half_sum list = (head list) / 2 + half_sum (tail list)
    
mult2 [] = []
mult2 list = (head list) * 2 : mult2 (tail list)

drop_evens list
    | [] <- list             = []
    | mod (head list) 2 == 1 = head list : drop_evens (tail list)
    | otherwise              = drop_evens (tail list)

triple list
    | [] <- list = []
    | otherwise = h : h : h : triple (tail list)
    where h = head list

mult_adjacent list
    | []         <- list = []
    | [_]        <- list = error "Uneven number of elements"
    | [x,y]      <- list = [x*y]
    | (x:y:z:xs) <- list = x*y : mult_adjacent (z:xs)

get_ele _ [] = 0
get_ele i (x:xs)
    | i == 0 = x
    | otherwise = get_ele (i-1) xs

drop_ele _ [] = []
drop_ele i (x:xs)
    | i == 0 = drop_ele (i-1) xs
    | otherwise = x : drop_ele (i-1) xs

div_list _ [] = []
div_list [] _ = []
div_list (x:xs) (y:ys) = x/y : div_list xs ys

longer [] _ = False
longer _ [] = True
longer list1 list2 = longer (tail list1) (tail list2)

div3_and_not [] = ([], [])
div3_and_not (x:xs)
    | mod x 3 == 0 = (x:div3, not)
    | otherwise    = (div3, x:not)
    where (div3, not) = div3_and_not xs

vowels_and_consonants [] = ([], [])
vowels_and_consonants (ch:chs)
    | elem (ch) "aeiou" = (ch:v, c)
    | otherwise         = (v, ch:c)
    where (v, c) = vowels_and_consonants chs

fast_lucas_help 1 = [1, 2]
fast_lucas_help n = x + y : (x:y:xs)
    where (x:y:xs) = fast_lucas_help $ n-1
fast_lucas n = head $ fast_lucas_help n

mult_by_pos_help pairs = [a * b | (a, b) <- pairs]
mult_by_pos list = mult_by_pos_help $ zip [0..] list

-- Collatz Question

collatz_length n l  -- gets the length of the collatz sequence for n number
    | n == 1       = l
    | mod n 2 == 0 = collatz_length (div n 2) l+1
    | otherwise    = collatz_length (3 * n + 1) l+1

collatz_result n = n : [collatz_length n 1]  -- binds n and its collatz length together in a 2 item list

all_collatz_results n  -- gets the length of every collatz number
    | n == 0    = []
    | otherwise = collatz_result n : all_collatz_results (n-1)

collatz_finder (x:xs)  -- recursive loop through the numbers and their collatz lengths to find the longest one
    | xs == []                = x
    | tail x < tail (head xs) = collatz_finder xs 
    | otherwise               = collatz_finder (x:tail(xs))

longest_collatz n = (head . collatz_finder . all_collatz_results) n

minus_one x = x - 1

quad_power x = 4^x

add_three x y z = x + y + z

area r = pi * r**2

mod_three x = mod x 3

mod3or5 x = if mod x 3 == 0 || mod x 5 == 0 then True else False

min_max a b c d = min a b + max c d

quadratic a b c = (-b + sqrt(b**2 - 4 * a * c)) / (2 * a)

gt_100 x = if x > 100 then 1 else 0

switch x y c = if c == 1 then x else y

my_max x y = if x > y then x else y

fizzbuzz x = if mod x 3 == 0 && mod x 5 == 0 then "Fizzbuzz!" else "Nope"

question1 x = let a = x * x in 2 * a

question2 x = let a = x + 1; b = a * a; c = 2^b in a + b - c

bounded_square x = let a = x*x in if a < 100 then a else 100

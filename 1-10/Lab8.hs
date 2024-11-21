--Part 2
--Question a, b, c
data Direction = North | East | South | West deriving (Show, Eq, Read, Ord)

--Question d
is_north :: Direction -> Bool
is_north d = if d == North then True else False

--Question e
dir_to_int :: Direction -> Int
dir_to_int North = 1
dir_to_int East  = 2
dir_to_int South = 3
dir_to_int West  = 4

--Part 3
data Point = Point Int Int deriving (Show, Read, Eq)

--Question a
same :: Int -> Point
same x = Point x x

--Question b
is_zero :: Point -> Bool
is_zero x = if x == Point 0 0 then True else False

--Question c
mult_point :: Point -> Int
mult_point (Point x y) = x * y

--Question d
up_two :: Point -> Point
up_two (Point x y) = Point x (y + 2)

--Question e
add_points :: Point -> Point -> Point
add_points (Point a b) (Point c d) = Point (a+c) (b+d)

--Part 4
--Question b
not_nothing :: Eq a => Maybe a -> Bool
not_nothing s = if s == Nothing then False else True

--Question c
safe_tail :: [a] -> Maybe [a]
safe_tail [] = Nothing
safe_tail list = Just(tail list)

--Question d
mult_maybe :: Maybe Int -> Maybe Int -> Maybe Int
mult_maybe (Just x) (Just y) = Just (x * y)
mult_maybe _ _ = Nothing

--Part 5
--Question b
return_two :: Int -> Either Bool Char
return_two n = if n == 1 then Left True else Right 'a'

--Question c
show_right :: Either String Int -> String
show_right (Left x)  = x 
show_right (Right y) = show y

--Part 6
--Question a
data List a = Cons a (List a) | Empty deriving (Show, Read)

--Question c
is_empty :: List a -> Bool
is_empty Empty = True 
is_empty _ = False 

--Question d
is_single :: List a -> Bool
is_single (Cons _ Empty) = True
is_single _ = False

--Question e
mult :: List Int -> Int
mult Empty = 1
mult (Cons x xs) = x * mult xs

--Question f
our_map :: (a -> b) -> List a -> List b
our_map _ Empty = Empty                          
our_map f (Cons x xs) = Cons (f x) (our_map f xs)

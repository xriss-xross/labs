--Provided functions

get :: [String] -> Int -> Int -> Char
get maze x y = (maze !! y) !! x 

modify_list :: [a] -> Int -> a -> [a]
modify_list list pos new =
    let
        before = take  pos    list
        after  = drop (pos+1) list
    in
        before ++ [new] ++ after

set :: [String] -> Int -> Int -> Char -> [String]
set maze x y char = 
    let
        line     = maze !! y
        new_line = modify_list line x char
        new_maze = modify_list maze y new_line
    in
        new_maze

--Question 1
maze_path = "./maze2.txt"

get_maze :: String -> IO [String]
get_maze path = do
    maze <- (readFile path)
    return (lines maze)

--Question 2
print_maze :: [String] -> IO ()
print_maze maze = do
    putStrLn $ unlines maze

--Question 3
is_wall :: [String] -> (Int, Int) -> Bool
is_wall maze (x, y) =
    if (maze !! x) !! y == '#'
        then True
        else False

--Question 4
place_object :: [String] -> (Int, Int) -> Char -> [String]
place_object maze (x, y) c =
    set maze x y c

--Question 5
move :: (Int, Int) -> Char -> (Int, Int)
move (x, y) 'w' = (x, (y+1))
move (x, y) 's' = (x, (y-1))
move (x, y) 'd' = ((x+1), y)
move (x, y) 'a' = ((x-1), y)
move cords _    = cords

--Question 6
can_move :: [String] -> (Int, Int) -> Char -> Bool
can_move maze (x, y) c =
    let (x', y') = move (x, y) c
    in is_wall maze (x', y')

--Question 7
game_loop :: [String] -> (Int, Int) -> (Int, Int) -> IO ()
game_loop maze (px, py) (ex, ey) = do
    let new_maze = set (set maze px py '@') ex ey '>' 
    print_maze new_maze

    --TODO: Get input and change maze state
    --inp <- getLine

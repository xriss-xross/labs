--Part 3
--Question c
echo :: IO ()
echo = do
    str <- getLine
    putStrLn str

--Question d
double_echo :: IO ()
double_echo = do
    str <- getLine
    putStrLn str
    putStrLn str

--Question e
put_two_strs :: String -> String -> IO ()
put_two_strs s1 s2 = do
    putStrLn s1
    putStrLn s2

--Part 4
--Question a
times_two :: IO ()
times_two = do
    inp <- getLine
    let int = read inp :: Int
    putStrLn (show $ int*2)

--Question b
add :: IO ()
add = do
    inp1 <- getLine
    inp2 <- getLine
    let
        int1 = read inp1 :: Int
        int2 = read inp2 :: Int
    putStrLn (show $ int1 + int2)

--Question c
io_reverse :: IO ()
io_reverse = do
    inp <- getLine
    putStrLn (reverse inp)

--Question d
guess_42 :: IO ()
guess_42 = do
    inp <- getLine
    let int = read inp :: Int
    if int == 42
        then putStrLn "correct"
        else putStrLn "wrong"

--Part 5
--Question a
get_bool :: IO Bool
get_bool = do
    inp <- getLine
    let bool = read inp :: Bool
    if bool
        then return True
        else return False

--Question b
get_two_and_add :: IO Int
get_two_and_add = do
    inp1 <- getLine
    inp2 <- getLine
    let
        int1 = read inp1 :: Int
        int2 = read inp2 :: Int
    return (int1 + int2)

--Question c
gt10 :: IO Bool
gt10 = do
    inp <- getLine
    let int = read inp :: Int
    if int > 10
        then return True
        else return False

--Question d
get_two_strings :: IO (String, String)
get_two_strings = do
    inp1 <- getLine
    inp2 <- getLine
    return (inp1, inp2)

--Part 6
--Question a
add_one_forever :: IO ()
add_one_forever = do
    inp <- getLine
    let int = read inp :: Int
    putStrLn (show $ int+1)
    add_one_forever

--Question b
echo_until_quit :: IO ()
echo_until_quit = do
    inp <- getLine
    putStrLn inp
    echo_until_quit

--FIX ME
--Question c
print_numbers_between :: Int -> Int -> IO ()
print_numbers_between a b = do
    if a < b
        then do
            putStrLn (show a) 
            print_numbers_between (a+1) b
        else
            putStrLn (show b)

--Part 7
--Question 1
print_file :: String -> IO ()
print_file file = putStrLn $ readFile file
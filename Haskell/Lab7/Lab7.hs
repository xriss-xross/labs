-- Part A&B Tests
type Transaction = (Char, Int, Int, String, Int) 

test_log :: [Transaction]
test_log = [('B', 100, 1104,  "VTI",  1),
            ('B', 200,   36, "ONEQ",  3),
            ('B',  50, 1223,  "VTI",  5),
            ('S', 150, 1240,  "VTI",  9),
            ('B', 100,  229, "IWRD", 10),
            ('S', 200,   32, "ONEQ", 11), 
            ('S', 100,  210, "IWRD", 12)
            ]

-- Part A
-- Question 1
transaction_to_string :: Transaction -> String
transaction_to_string (act, vol, price, name, day) = (
    action act -- FIXME: MAKE A WHERE STATEMENT
    ++ (show vol)
    ++ " units of "
    ++ name
    ++ " for "
    ++ (show price)
    ++ " pounds each on day "
    ++ (show day)
    )

action :: Char -> String
action 'B' = "Bought "
action 'S' = "Sold "

-- Question 2
trade_report_list :: [Transaction] -> [String]
trade_report_list = map transaction_to_string

-- Question 3
stock_test :: String -> Transaction -> Bool
stock_test name_q = (\(_, _, _, name, _) -> name == name_q)

-- Question 4
get_trades :: String -> [Transaction] -> [Transaction]
get_trades name_q = filter (stock_test name_q)

-- Question 5
trade_report :: String -> [Transaction] -> String
trade_report name_q log = 
    let f_log = get_trades name_q log
    in unlines (map transaction_to_string f_log)

-- Part B
-- Question 6
update_money :: Transaction -> Int -> Int
update_money (act, vol, price, _, _) =
    (\account ->
        if act == 'B'
            then account - (vol * price)
            else account + (vol * price)
    )

-- Question 7
profit :: [Transaction] -> String -> Int
profit log stock = foldr (\transaction account ->
    if stock_test stock transaction
        then update_money transaction account
        else account
    ) 0 log

-- Question 8
profit_report :: [String] -> [Transaction] -> String
profit_report stocks log =
    unlines (map (\stock ->
        stock
        ++ ": "
        ++ show (profit log stock)
        ) stocks
    )

-- Part C Tests
test_str_log = "BUY 100 VTI 1\nBUY 200 ONEQ 3\nBUY 50 VTI 5\nSELL 150 VTI 9\nBUY 100 IWRD 10\nSELL 200 ONEQ 11\nSELL 100 IWRD 12\n"

type Prices = [(String, [Int])]

test_prices :: Prices
test_prices = [
                ("VTI", [1689, 1785, 177, 1765, 1739, 1725, 1615, 1683, 1655, 1725, 1703, 1726, 1725, 1742, 1707, 1688, 1697, 1688, 1675]),
                ("ONEQ", [201, 203, 199, 199, 193, 189, 189, 183, 185, 190, 186, 182, 186, 182, 182, 186, 183, 179, 178]),
                ("IWRD", [207, 211, 213, 221, 221, 222, 221, 218, 226, 234, 229, 229, 228, 222, 218, 223, 222, 218, 214])
              ]

--Part C
--Question 9
type Order = [String]

complex_profit_report :: String -> Prices -> String
complex_profit_report orders prices =
    let 
        stocks = [n | (n, _) <- prices]
        log = transaction_log orders prices
    in profit_report stocks log

-- Uses tranaction_help to construct a full log
transaction_log :: String -> Prices -> [Transaction]
transaction_log orders prices =
    let log_s = map words $ lines orders
    in map (\x -> tranaction_help x prices) log_s

-- Takes a string order, returns a Transaction type
tranaction_help :: Order -> Prices -> Transaction
tranaction_help [actStr, volStr, name, dayStr] prices  =
    let
        act = if actStr == "BUY" then 'B' else 'S'
        vol = read volStr :: Int
        day = read dayStr :: Int
        price = (head [p | (n, p) <- prices, n == name]) !! (day - 1)
    in (act, vol, price, name, day)

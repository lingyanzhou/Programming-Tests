import unittest
from solution import Solution

class TestSolution(unittest.TestCase):
                       
    def test_all(self):
        tests = zip(["204",
                        "*********",
                        "1001",
                        "*10*1",
                        "**",
                        "1*",
                        "*1",
                        "1*1",
                        "3*2"],
                    [1,
                        291868912,
                        0,
                        99,
                        96,
                        18,
                        11,
                        20,
                        11])
        for t in tests:
            sol = Solution()
            self.assertEqual(sol.numDecodings(t[0]), t[1])

if __name__ == '__main__':
    unittest.main()
    

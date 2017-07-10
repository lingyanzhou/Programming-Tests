import unittest
from solution import Solution

class TestSolution(unittest.TestCase):
                       
    def test_all(self):
        tests = zip(["x+5-3+x=6+x-2",
                        "x=x",
                        "2x=x",
                        "x=x+2",
                        "2x+3x-6x=x+2",
                        "2x=-2",
                        "2=-2x",
                        "0x=0",
                        "3=-4"], 
                        ["x=2",
                        "Infinite solutions",
                        "x=0",
                        "No solution",
                        "x=-1",
                        "x=-1",
                        "x=-1",
                        "Infinite solutions",
                        "No solution"])
        for t in tests:
            sol = Solution()
            self.assertEqual(sol.solveEquation(t[0]), t[1])


if __name__ == '__main__':
    unittest.main()
    

import unittest
from solution import Solution

class TestSolution(unittest.TestCase):
                       
    def test_all(self):
        tests = zip([([2,5],
                            [[3,0,5],[1,2,10]],
                            [3,2]
                            ),
                        ([2,3,4],
                            [[1,1,0,4],[2,2,1,9]],
                            [1,2,1]
                            ),
                        ([6,6,6,6,6,6],
                            [[1,0,0,0,0,0,0],[0,1,0,0,0,0,0],[0,0,1,0,0,0,0],[0,0,0,1,0,0,0],[0,0,0,0,1,0,0],[0,0,0,0,0,1,0]],
                            [6,6,6,6,6,6]
                            )],
                    [14,
                        11,
                        0])
        for t in tests:
            sol = Solution()
            self.assertEqual(sol.shoppingOffers(t[0][0], t[0][1], t[0][2]), t[1])


if __name__ == '__main__':
    unittest.main()
    

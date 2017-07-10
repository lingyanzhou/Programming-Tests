import numpy as np

class Solution:
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        sign = 1
        multiplier = -1
        isX = False
        lhs = True
        xCoef = 0
        const = 0
        for i in equation+"$":
            if i=='-' or i=='+' or i=='=' or i=='$':
                
                if isX:
                    if multiplier>=0:
                        if lhs:
                            xCoef += sign*multiplier
                        else:
                            xCoef -= sign*multiplier
                else:
                    if multiplier>=0:
                        if lhs:
                            const -= sign*multiplier
                        else:
                            const += sign*multiplier
                multiplier = -1
                isX = False
                if i=='-':
                    sign = -1
                elif i=='+':
                    sign = 1
                elif i=='=':
                    sign = 1
                    lhs=False
                elif i=='$':
                    sign = 1
            elif i.isdigit():
                if multiplier<0:
                    multiplier =0
                multiplier = multiplier*10+int(i)
            elif i=='x':
                if multiplier<0:
                    multiplier =1
                isX = True
        if xCoef==0 and const==0:
            return 'Infinite solutions'
        if xCoef==0 and const!=0:
            return "No solution"
        return "x="+str(const//xCoef)

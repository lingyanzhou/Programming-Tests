#ifndef __SOLUTION_HPP__
#define __SOLUTION_HPP__

#include <cstring>

class Solution {
public:
    char *m_pData;
    Solution() {
        this->m_pData = NULL;
    }
    Solution(char *pData) {
        this->m_pData = pData;
    }

    // Implement an assignment operator
    Solution operator=(const Solution &object) {
        if (&object==this) {
            return *this;
        }
        if (object.m_pData==NULL) {
            if (m_pData!=NULL) {
                delete [] m_pData;
                m_pData=NULL;
            }
            return *this;
        } else {
            if (m_pData!=NULL) {
                delete [] m_pData;
                m_pData=NULL;
            }
            size_t len = strlen(object.m_pData);
            m_pData = new char[len+1];
            strncpy(m_pData, object.m_pData, len+1);
            return *this;
        }

        return *this;
    }
};


#endif // __SOLUTION_HPP__

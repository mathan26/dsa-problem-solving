package com.mathan.neetcode.binary_search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // formula for getting the mid
            int midValue = matrix[mid / n][mid % n];

            if(midValue == target) {
                return true;
            } else if(midValue < target) {
                left = mid + 1;
            }else {
                right = right -1;
            }
        }
        return false;
    }
}

/*
* Here's a clear and simple **intuition and step-by-step approach** for solving **“Search a 2D Matrix”** (LeetCode 74):

---

## 🧠 **Problem Intuition**

You're given a 2D matrix where:

* Each row is sorted in ascending order.
* The first integer of each row is greater than the last integer of the previous row.

### 🔍 Intuition:

* Imagine this 2D matrix is **flattened into a 1D sorted array**.
* You can then apply **Binary Search** over the entire 2D matrix by mapping 1D index back to 2D.

---

## 🪜 **Step-by-Step Approach**

### ✅ Step 1: Understand the Matrix

If matrix is like:

```txt
[
  [1, 3, 5],
  [7, 9, 11],
  [13, 15, 17]
]
```

You can think of it as:

```txt
[1, 3, 5, 7, 9, 11, 13, 15, 17]
```

### ✅ Step 2: Flatten index conversion

Given `cols = matrix[0].length`:

* For any `mid` in 1D, get row = `mid / cols`, col = `mid % cols`

---

### ✅ Step 3: Binary Search Setup

* Let `low = 0`, `high = m * n - 1` (where m = number of rows, n = number of cols)
* While `low <= high`:

  * `mid = (low + high) / 2`
  * Convert mid to matrix index: `row = mid / n`, `col = mid % n`
  * Compare `matrix[row][col]` with `target`

---

### ✅ Step 4: Decision Making

* If `matrix[row][col] == target`: return true
* If `matrix[row][col] < target`: move right → `low = mid + 1`
* If `matrix[row][col] > target`: move left → `high = mid - 1`

---

```

---

## 🧠 Short Memory Notes:

* Matrix is like a 1D sorted array.
* `mid / cols` → row, `mid % cols` → col
* Binary search: `low`, `mid`, `high`

Want a dry run example?

*
*
* */
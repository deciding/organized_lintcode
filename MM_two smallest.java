static void TwoSmallestValues(int[] a, out int min1, out int min2)
        {

            min1 = a[0];
            min2 = a[1];
            if (min2 < min1)
            {
                min1 = a[1];
                min2 = a[0];
            }

            for (int i = 2; i < a.Length; i++)
                if (a[i] < min1)
                {
                    min2 = min1;
                    min1 = a[i];
                }
                else if (a[i] < min2)
                {
                    min2 = a[i];
                }

        }

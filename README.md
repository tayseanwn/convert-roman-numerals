# convert-roman-numerals
<h1>Language and Framework</h1>
Java (Eclipse)

<h1>Overview</h1>
The unique property of this numbering system (Roman numerals) is that there are 7 symbols
that represent different numbers, and all other numbers are represented as some combination
of these symbols. 

<h2>Purpose</h2>
Convert Roman Numerals to Arabic Numebers

<h2>Design</h2>

There are certain rules for valid Roman numerals. Numerals that break these rules are
considered invalid and they are not real Roman numerals.
- I, X, and C, and M can be repeated up to, but not more than, 3 times in a row. For
example, III is valid (3) but IIII is invalid.
- V, L, and D cannot be repeated at all. For example, DD is invalid.
- A smaller value immediately before a greater value means we subtract the smaller value
from the greater value. For example, IV means 1 less than 5, which is 4.
- A larger value immediately before a smaller value means we add the two values
together. For example, XI means 10 plus 1, which is 11.
- Two consecutive numbers of the same value means we add them together (as long as
they do not break the earlier rules about repeats). For example, XX means 10 plus 10,
which is 20.

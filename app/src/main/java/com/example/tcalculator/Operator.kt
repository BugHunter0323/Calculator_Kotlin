package com.example.tcalculator

sealed class Operator(val x:Long) {
   abstract fun calculator(y:Long):Long
    class add(x:Long):Operator(x)
    {
        override fun calculator(y: Long): Long {
            return x+y
        }

    }
    class sub(x:Long):Operator(x)
    {
        override fun calculator(y: Long): Long {
            return x-y
        }

    }
    class mult(x:Long):Operator(x)
    {
        override fun calculator(y: Long): Long {
            return x*y
        }

    }

    class divide(x:Long):Operator(x)
    {
        override fun calculator(y: Long): Long {
            return x/y
        }

    }
}
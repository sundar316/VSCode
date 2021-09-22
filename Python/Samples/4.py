'''import calendar
year = 2021
month = 4
print(calendar.month(year,month))'''

import turtle
a = turtle.Turtle()
a.getscreen().bgcolor("pink")

a.penup()
a.goto(-200, 10)
a.pendown()
a.color("blue")

a.speed(30)
def star(turtle, size):
    if size<=10:
        return
    else:
        turtle.begin_fill()
    for i in range(5):
        turtle.forward(size)
        star(turtle,size/3)
        turtle.left(216)
        turtle.end_fill()

star(a, 360)
turtle.done()
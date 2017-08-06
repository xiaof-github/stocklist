class Student(object):
    count = 0
    books = []
    def __init__(self, name, age):
        self.name = name
        self.age = age
    pass


Student.books.extend(["python", "javascript"])
print "Student book list: %s" % Student.books
# class can add class attribute after class defination
Student.hobbies = ["reading", "jogging", "swimming"]
Student.test = ["test"]
print "Student test list: %s" % Student.test
print dir(Student)

print Student.__name__
print Student.__doc__
print Student.__bases__
print Student.__dict__
print Student.__module__
print Student.__class__
print

wilber = Student("Wilber", 28)
print "%s is %d years old" %(wilber.name, wilber.age)
# class instance can add new attribute
# "gender" is the instance attribute only belongs to wilber
wilber.gender = "male"
print "%s is %s" %(wilber.name, wilber.gender)
# class instance can access class attribute
print dir(wilber)
wilber.books.append("C#")
print wilber.books

print

will = Student("Will", 27)
print "%s is %d years old" %(will.name, will.age)
# will shares the same class attribute with wilber
# will don't have the "gender" attribute that belongs to wilber
print dir(will)
print will.books

print
Hill = Student("Hill", 26)
print "%s is %d years old" %(Hill.name, Hill.age)
Hill.books.append("java")
print Hill.books

print "will: %s" %will.books
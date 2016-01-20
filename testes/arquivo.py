import sqlite3

#Database creation

conn = sqlite3.connect('users.db')
print("Database sucessfully created\n")

#Table creation

conn.execute('''CREATE TABLE IF NOT EXISTS USERS
  (id INT PRIMARY KEY NOT NULL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    avatar TEXT NOT NULL,
    view_count INT NOT NULL);''')



print("Table sucessfully created\n")

#Inserting data to the table
user_list = open("user_data.txt","r");
for line in user_list:
  data_row = "VALUES ("+line+");"
  conn.execute("INSERT INTO USERS (id, first_name, last_name, avatar, view_count) "+data_row)

#Printing the table
cursor = conn.execute("SELECT id, first_name, last_name, avatar, view_count from USERS")

for row in cursor:
  print "id = "+str(row[0])
  print "first_name = "+row[1]
  print "last_name = "+row[2]
  print "avatar = "+row[3]
  print "view_count = "+str(row[4])
  print ""

 # Printing the table
cursor = conn.execute("SELECT * from USERS where ID = 0")

for row in cursor:
  print "id = "+str(row[0])
  print "first_name = "+row[1]
  print "last_name = "+row[2]
  print "avatar = "+row[3]
  print "view_count = "+str(row[4])
  print ""
conn.close();
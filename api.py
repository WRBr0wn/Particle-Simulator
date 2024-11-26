from flask import Flask, redirect, url_for, request
from flask import jsonify
import csv

app = Flask(__name__)

obstacles = [] # or maybe {} or [{}]
with open('obstacles.csv', 'r') as file:
    csvFile = csv.DictReader(file)
    for line in csvFile:
        print(line)
        obstacles.append(line)

@app.route('/obstacle', methods=['POST'])
def add_obstacle():
    # add to the obstacles
    obstacle = request.json
    obstacles.append(obstacle)
    # save to csv
    with open('obstacles.csv', 'a', newline='') as csvfile:
        fieldnames = ['x', 'y']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writerow(obstacle)

    return 'Success'

@app.route('/obstacle', methods=['DELETE'])
def del_obstacle():
    # del from obstacles (perhaps use an id)
    obstacle = request.json
    obstacles.remove(obstacle)

    #del from csv

    return 'Success'

@app.route('/obstacles', methods=['GET'])
def get_obstacles():
    return "success"




if __name__ == '__main__':
    app.run(debug=True)
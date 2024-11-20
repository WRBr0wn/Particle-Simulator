from flask import Flask, redirect, url_for, request
from flask import jsonify
import csv

app = Flask(__name__)

# ************************************
# Mouse Clicks Exmaple From Processing
# ************************************
mouse_clicks = []

@app.route('/mouse_click', methods=['POST'])
def add_mouse_click():
    mouse_click = request.json
    mouse_clicks.append(mouse_click)
    return 'Success'

@app.route('/mouse_click', methods=['DELETE'])
def del_mouse_click():
    # mouse_click = request.json
    mouse_clicks.remove(mouse_clicks[-1])
    return 'Success'

@app.route('/mouse_clicks', methods=['GET'])
def get_mouse_clicks():
    return jsonify(mouse_clicks)

# ************************************
# Particle Simulation HW4
# ************************************

obstacles = [] # or maybe {} or [{}]
with open('obstacles.csv', 'r') as file:
    csvFile = csv.DictReader(file)
    for line in csvFile:
        obstacles += line

@app.route('/obstacle', methods=['POST'])
def add_obstacle():
    # add to the obstacles
    obstacle = request.json
    obstacles.append(obstacle)

    # save to csv
    with open('obstacles.csv', 'w', newline='') as csvfile:
        fieldnames = ['x', 'y', 'button', 'id']
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
def get_mouse_clicks():
    return jsonify(obstacles)




if __name__ == '__main__':
    app.run(debug=True)
Feature: initial calibration

GIVEN
    A Rover that just arrived on the planet
WHEN
    It is calibrated with initial coordinates (5, 5)
THEN
    It faces North


Feature: Going forward facing North

GIVEN
    A Rover at coordinates (5, 5) facing North
WHEN
    It goes forward
THEN
    Its new coordinates are (5, 6) facing North



Feature: Going left facing North

GIVEN
    A Rover at coordinates (5, 5) facing North
WHEN
    It goes left
THEN
    Its coordinates are still (5, 5) facing West


Feature: Going right facing North

GIVEN
    A Rover at coordinates (5, 5) facing North
WHEN
    It goes right
THEN
    Its coordinates are still (5, 5) facing East



Feature: Sending 2 requests facing North

GIVEN
    A Rover at coordinates (5, 5) facing North
    There are no obstacles
WHEN
    Receives [F,F] command sequence
THEN
    Its new coordinates are (5, 7) facing North



Feature: Sending 7 requests facing North

GIVEN
    A Rover at coordinates (5, 5) facing North
    There are no obstacles
WHEN
    Receives [F,R,F,R,F,R,F] command sequence
THEN
    Its coordinates are still (5, 5) facing West



Feature: Going forward facing East

GIVEN
    A Rover at coordinates (5, 5) facing East
WHEN
    It goes right and goes forward
THEN
    Its new coordinates are (6, 5) facing East



Feature: Passing horizontal boundaries

GIVEN
    A world of size (10, 10)
    A Rover at coordinates (0, 0) facing West
WHEN
    It goes forward
THEN
    Its new coordinates are (9, 0) facing West



Feature: Passing north pole

GIVEN
    The world is of size (10, 10)
    Rover is at (0,0), facing North
WHEN
    It goes forward
THEN
    Its new coordinates are (9, 9) facing South



Feature: Obstacle detection

GIVEN
    A Rover at coordinates (0, 0) facing East
    An obstacle at coordinates (1, 0)
WHEN
    It goes forward
THEN
    Its coordinates are still (0, 0) facing East



Feature: ?

GIVEN
    ?
WHEN
    ?
THEN
    ?
    


Feature : ?

GIVEN
    ?
WHEN
    ?
THEN
    ?
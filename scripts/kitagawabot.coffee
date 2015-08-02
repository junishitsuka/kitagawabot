# Description:
#   Example scripts for you to examine and try out.
#
# Notes:
#   They are commented out by default, because most of them are pretty silly and
#   wouldn't be useful and amusing enough for day to day huboting.
#   Uncomment the ones you want to try and experiment with.
#
#   These are from the scripting documentation: https://github.com/github/hubot/blob/master/docs/scripting.md

fs = require 'fs'
path = require 'path'

module.exports = (robot) ->
  robot.hear /image/i, (res) ->
    url = fs.readFileSync path.resolve __dirname, "../scraping/images/url_list"
    arr = url.toString().split '\n'
    res.send res.random arr.filter (str) -> str != ""

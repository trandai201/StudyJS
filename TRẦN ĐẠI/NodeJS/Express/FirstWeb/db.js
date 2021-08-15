const low = require('lowdb')
const FileSync = require('lowdb/adapters/FileSync')
const shortid = require('shortid');

const adapter = new FileSync('db.json')
const db = low(adapter)

// Set some defaults
db.defaults({ listUser: [] })
    .write()

module.exports = db;
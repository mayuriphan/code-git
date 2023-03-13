const express = require('express');
const cors = require('cors');
const mongoose = require('mongoose');

const app = express()
require('dotenv').config();
const port = process.env.PORT || 5000;

app.use(cors());
app.use(express.json());

// fetch atls_uri from .env file
const uri = process.env.atls_uri;
// create connection to mongodb atlas
mongoose.connect(uri, { useNewUrlParser: true });
const cnctn = mongoose.connection;
cnctn.once('open', () => {
  console.log("Atlas Connected Successfully !");
})

const getGtrRouter = require('./routes/getGtr');
app.use('/getGtr', getGtrRouter);

app.listen(port, () => {
    console.log(`Server on port: ${port}`);
});

// server.js

const express = require('express');
const cors = require('cors');

const app = express();
const port = 3001;

app.use(cors());
app.use(express.json());

app.get('/', (req, res) => {
    res.send('Server running');
});

app.post('/', (req, res) => {
  res.json({ message: 'Server running POST', received: req.body });
});

app.listen(port, () => {
    console.log(`Server running on http://localhost:${port}`)
});
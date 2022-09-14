import React from 'react';
import './App.css';
import bot from './images/bot.png';
import ChatBot from 'react-simple-chatbot';
import { ThemeProvider } from 'styled-components';


const steps = [
    {
        id: '0',
        message: 'Welcome User!',
        trigger: '1',
    }, {
        id: '1',
        message: " Hello User, do you want more information to select guitars?",
        trigger: '4'
    }, {
        id: '4',
        options: [
            { value: 1, label: 'Guitar 1',trigger:'g1' },
            { value: 2, label: 'Guitar 2',trigger:'g2' },
            { value: 3, label: 'Guitar 3',trigger:'g3' },
            { value: 4, label: 'Guitar 4',trigger:'g4' },

        ],
    },{
      id:'g1', 
      message:'Acoustic guitars have a wooden body, and strings made of steel.', 
      trigger:'m1'
    },
    {
      id:'g2', 
      message:'Electric guitars come with a wooden body with a pickup that picks up vibration from the strings and converts that to electric signals', 
      trigger:'m1'
    },{
      id:'g3', 
      message:'An electric acoustic guitar includes a pickup system (on-board microphone) and a pre-amp (EQ), that allows the guitar to be connected to an amplifier and played through.', 
      trigger:'m1'
    },
    {
      id:'g4', 
      message:'The bass guitars (commonly known as “electric bass”) are four-string guitars that look like electric guitars but produce only low-frequency sounds.', 
      trigger:'m1'
    },
    {
      id: 'm1',
      message : 'Do you wnat to check information on guitars again?',
      trigger: '5',
    },
    {
      id: '5',
        options: [
            { value: 1, label: 'Yes',trigger:'m2' },
            { value: 2, label: 'No',trigger:'m3' },
        ]
    },
    {
      id:"m2",
      options: [
        { value: 1, label: 'Guitar 1',trigger:'g1' },
        { value: 2, label: 'Guitar 2',trigger:'g2' },
        { value: 3, label: 'Guitar 3',trigger:'g3' },
        { value: 4, label: 'Guitar 4',trigger:'g4' },
    ],   
    },
    {
      id:"m3",
      message : "Hope it helped ! Bye ! ",
      end: true,
    }
];
 
// Creating our own theme
const theme = {
    background: 'white',
    headerBgColor: '#66B2FF',
    headerFontSize: '20px',
    botBubbleColor: '#3399FF',
    headerFontColor: 'white',
    botFontColor: 'black',
    userBubbleColor: '#FF5733',
    userFontColor: 'black',
};
 
// Set some properties of the bot
const config = {
    botAvatar: bot,
    floating: true,
};
 
function App() {
    return (
        <div className="App">
            <ThemeProvider theme={theme}>
                <ChatBot
                // chatbot header
                    headerTitle="ChatBot"
                    steps={steps}
                    {...config}
 
                />
            </ThemeProvider>
        </div>
    );
}


export default App;

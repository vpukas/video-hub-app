// SubscribedChannels.js
import React, {useEffect, useState} from 'react';
import axios from "axios";
import './VideoCard.css';
import './SubscribedChannels.css';
import {Avatar} from "@mui/material/";
import {Link} from "react-router-dom";

function SubscribedChannels( ) {

    const [channels, setChannels] = useState([]); // State to store the thumbnail data URL
    const [token, setToken] = useState(localStorage.getItem("token"));

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/subscriptions', {
            headers: {
                Authorization: 'Bearer ' + token
            }
        })
            .then(response => {
                setChannels(response.data);
            });
    }, []);

    return (
        <div className="subscribed-channels-container">
            <div className="subscribed-channels">
                <h2>Subscribed Channels</h2>
                <ul>
                    {channels.map(channel => (
                        <li key={channel.id}>
                            <Avatar className="videoCard__avatar" alt={channel.username} src="./logo.svg" />
                            {/* Display channel information here */}
                            <Link to={`/channel/${channel.id}`}><p>{channel.username}</p></Link>
                            {/* You can add more channel details as needed */}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default SubscribedChannels;

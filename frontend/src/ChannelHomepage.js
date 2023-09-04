import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import './ChannelHomepage.css';
import './RecommendedVideos.css';
import VideoCard from './VideoCard';
import { Avatar, Button } from "@mui/material"; // Import your CSS file

function ChannelHomepage() {
    const { channelId } = useParams();
    const [channelInfo, setChannelInfo] = useState(null);
    const [videos, setVideos] = useState([]);
    const [token, setToken] = useState(localStorage.getItem('token'));
    const [isSubscribed, setIsSubscribed] = useState(false); // Track subscription status

    useEffect(() => {
        // Fetch channel information
        axios
            .get(`http://localhost:8080/api/v1/channels/${channelId}`, {
                headers: {
                    Authorization: 'Bearer ' + token,
                },
            })
            .then((response) => {
                setChannelInfo(response.data);
            })
            .catch((error) => {
                console.error('Error fetching channel info:', error);
            });

        // Fetch channel videos
        axios
            .get(`http://localhost:8080/api/v1/channels/${channelId}/videos`, {
                headers: {
                    Authorization: 'Bearer ' + token,
                },
            })
            .then((response) => {
                setVideos(response.data);
            })
            .catch((error) => {
                console.error('Error fetching channel videos:', error);
            });


        axios
            .get(`http://localhost:8080/api/v1/subscriptions/${channelId}`, {
                headers: {
                    Authorization: 'Bearer ' + token,
                },
            })
            .then((response) => {
                setIsSubscribed(response.data);
            })
            .catch((error) => {
                console.error('Error fetching subscription status:', error);
            });
    }, [channelId, token]);

    // Function to handle the subscribe/unsubscribe action
    const handleSubscribe = () => {
        if (isSubscribed) {
            axios
                .post(`http://localhost:8080/api/v1/subscriptions/unsubscribe/${channelId}`, null, {
                    headers: {
                        Authorization: 'Bearer ' + token,
                    },
                })
                .then(() => {
                    setIsSubscribed(false);
                })
                .catch((error) => {
                    console.error('Error unsubscribing:', error);
                });
        } else {
            axios
                .post(`http://localhost:8080/api/v1/subscriptions/subscribe/${channelId}`, null, {
                    headers: {
                        Authorization: 'Bearer ' + token,
                    },
                })
                .then(() => {
                    setIsSubscribed(true);
                })
                .catch((error) => {
                    console.error('Error subscribing:', error);
                });
        }
    };

    return (
        <div>
            <div className="channel-container">
                {channelInfo && (
                    <div className="channel-header">
                        <Avatar className="channel-avatar" alt={channelInfo.username} src={"./logo.svg"} />
                        <div className="channel-info">
                            <h1 className="channel-title">{channelInfo.username}</h1>
                            <h3>{channelInfo.subscribers} subscribers</h3>
                            {/* Render subscribe button based on subscription status */}
                            {isSubscribed ? (
                                <Button variant="contained" onClick={handleSubscribe}>
                                    Unsubscribe
                                </Button>
                            ) : (
                                <Button variant="contained" color="primary" onClick={handleSubscribe}>
                                    Subscribe
                                </Button>
                            )}
                        </div>
                    </div>
                )}
            </div>
            <div className="recommendedvideos">
                <div className="recommendedVideos__videos">
                    {videos.map((video) => (
                        <VideoCard
                            key={video.id}
                            id={video.id}
                            title={video.title}
                            views={video.views}
                            channel={video.channelName}
                            channelImage="./logo.svg"
                            channelId={video.channelId}
                        />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default ChannelHomepage;

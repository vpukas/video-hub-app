import React, { useEffect, useState } from 'react';
import './VideoPage.css'; // Import the CSS file
import { useParams } from 'react-router-dom';
import axios from 'axios'; // Import useParams
import ThumbUpIcon from '@mui/icons-material/ThumbUp';
import ThumbDownIcon from '@mui/icons-material/ThumbDown';
import CommentSection from "./CommentSection";

function VideoPage() {
    const [videoBlob, setVideoBlob] = useState(null);
    const [token, setToken] = useState(localStorage.getItem('token'));
    const [videoData, setVideoData] = useState(null); // Initialize to null
    const [likeCount, setLikeCount] = useState(0);

    // Retrieve videoId from route parameters
    const { videoId } = useParams();

    useEffect(() => {
        // Fetch the video file from your REST API
        fetch(`http://localhost:8080/api/v1/videos/${videoId}`, {
            method: 'GET',
            headers: {
                Authorization: 'Bearer ' + token, // Replace with your authentication token if needed
            },
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.blob();
            })
            .then((data) => {
                setVideoBlob(data);
            })
            .catch((error) => {
                console.error('Error fetching video:', error);
            });
    }, [videoId]);

    useEffect(() => {
        axios
            .post(`http://localhost:8080/api/v1/videos/${videoId}/views/watch`, null, {
                headers: {
                    Authorization: 'Bearer ' + token, // Replace with your authentication token if needed
                }}
                )
    }, [])

    useEffect(() => {
        axios
            .get(`http://localhost:8080/api/v1/videos/${videoId}/data`, {
                headers: {
                    Authorization: 'Bearer ' + token, // Replace with your authentication token if needed
                },
            })
            .then((response) => {
                const videoData = response.data;
                setVideoData(videoData);
                setLikeCount(videoData.likes);
            })
            .catch((error) => {
                console.error('Error fetching video data:', error);
            });
    }, [videoId, token]);

    const handleLike = () => {
        // Make an API call to increment the like count on the server
        axios
            .post(`http://localhost:8080/api/v1/videos/${videoId}/rates/like`, null, {
                headers: {
                    Authorization: 'Bearer ' + token, // Replace with your authentication token if needed
                },
            })
            .then(() => {
                setLikeCount((prevCount) => prevCount + 1);
            })
            .catch((error) => {
                console.error('Error liking video:', error);
            });
    };

    const handleDislike = () => {
        // Make an API call to increment the dislike count on the server
        axios
            .post(`http://localhost:8080/api/v1/videos/${videoId}/rates/dislike`, null, {
                headers: {
                    Authorization: 'Bearer ' + token, // Replace with your authentication token if needed
                },
            })
            .catch((error) => {
                console.error('Error disliking video:', error);
            });
    };

    return (
        <div className="container">
            <div className="video-container">
                {videoBlob && (
                    <video controls>
                        <source src={URL.createObjectURL(videoBlob)} type="video/mp4" />
                        Your browser does not support the video tag.
                    </video>
                )}
            </div>
            <div className="video-info">
                {videoData && (
                    <>
                        <p>Title: {videoData.title}</p>
                        <p>Channel: <a href={videoData.channelUrl}>{videoData.channel}</a></p>
                        <p>Views: {videoData.views}</p>
                        {/* Add more properties as needed */}
                        <button onClick={handleLike}><ThumbUpIcon /> {likeCount}</button>
                        <button onClick={handleDislike}><ThumbDownIcon /> </button>
                    </>
                )}
            </div>

            {/* Render the CommentSection component */}
            {videoData && (
                <CommentSection videoId={videoId} token={token} />
            )}
        </div>
    );
}

export default VideoPage;

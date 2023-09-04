    import React, { useEffect, useState } from "react";
    import { Avatar } from "@mui/material/";
    import "./VideoCard.css";
    import { Link } from "react-router-dom";
    import axios from "axios";

    function VideoCard({
                           id,
                           image,
                           title,
                           channel,
                           views,
                           timestamp,
                           channelImage,
                           channelId,
                       }) {
        const [thumbnailDataUrl, setThumbnailDataUrl] = useState(null); // State to store the thumbnail data URL
        const [token, setToken] = useState(localStorage.getItem("token"));

        useEffect(() => {
            // Define the API endpoint for fetching the thumbnail based on the video id
            const apiUrl = `http://localhost:8080/api/v1/videos/${id}/image`;

            // Fetch the thumbnail image data as a blob
            axios
                .get(apiUrl, {
                    responseType: "blob",
                    headers: {
                        Authorization: "Bearer " + token,
                    },
                })
                .then((response) => {
                    // Assuming the API returns the image as a blob
                    const thumbnailBlob = response.data;

                    // Convert the thumbnail blob to a base64-encoded data URL
                    const reader = new FileReader();
                    reader.onload = () => {
                        setThumbnailDataUrl(reader.result);
                    };
                    reader.readAsDataURL(thumbnailBlob);
                })
                .catch((error) => {
                    console.error("Error fetching thumbnail:", error);
                });
        }, [id, token]);

        return (
            <div className="videoCard">
                <Link to={`/video/${id}`} className="videoCard__link">
                    <img
                        className="videoCard__thumbnail"
                        src={thumbnailDataUrl} // Use the data URL as the image source
                        alt=""
                    />
                </Link>

                <div className="videoCard__info">
                    <Avatar className="videoCard__avatar" alt={channel} src={channelImage} />
                    <div className="video__text">
                        <p style={{ fontSize: "14px", color: "#d9d9d9" }}>{title}</p>
                        <p
                            style={{
                                fontSize: "13px",
                                marginTop: "4px",
                                toolTip: "Hello",
                                color: "#d9d9d9",
                            }}
                        >
                            <Link
                                to={`/channel/${channelId}`}
                                style={{ fontFeatureSettings: "normal", color: "#d9d9d9" }}
                            >
                                {channel}
                            </Link>
                        </p>
                        <p style={{ marginTop: "3px", fontSize: "12px", color: "#d9d9d9" }}>
                            {`${views} views`} • {timestamp}
                        </p>
                    </div>
                </div>
            </div>
        );
    }

    export default VideoCard;

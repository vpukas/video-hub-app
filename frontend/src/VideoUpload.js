import React, { useState } from 'react';
import axios from 'axios';
import './VideoUpload.css';

function VideoUpload() {
    const [videoFile, setVideoFile] = useState(null);
    const [previewFile, setPreviewFile] = useState(null);
    const [name, setName] = useState('');
    const [token, setToken] = useState(localStorage.getItem("token"));

    const handleVideoChange = (event) => {
        const file = event.target.files[0];
        if (file) {
            setVideoFile(file);
        }
    };

    const handlePreviewChange = (event) => {
        const file = event.target.files[0];
        if (file) {
            setPreviewFile(file);
        }
    };

    const handleNameChange = (event) => {
        const name = event.target.value;
        setName(name);
    };

    const handleUpload = () => {
        if (videoFile && previewFile && name) {
            const formData = new FormData();
            formData.append('video', videoFile);
            formData.append('preview', previewFile);
            formData.append('name', name);

            // Make a POST request to your endpoint
            axios
                .post('http://localhost:8080/api/v1/videos', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        Authorization: 'Bearer ' + token,
                    },
                })
                .then((response) => {
                    console.log('Upload successful:', response.data);
                })
                .catch((error) => {
                    console.error('Error uploading video:', error);
                });
        } else {
            console.error('Video and preview files are required for upload.');
        }
    };

    return (
        <div className="video-upload-container">
            <h2 className="upload-title">Video Upload</h2>
            <div className="form-block">
                <label htmlFor="videoTitle">Video Title</label>
                <input type="text" id="videoTitle" value={name} onChange={handleNameChange} />
            </div>
            <div className="form-block">
                <label htmlFor="videoFile" className="file-label">
                    Upload Video
                    <input
                        type="file"
                        id="videoFile"
                        accept="video/*"
                        onChange={handleVideoChange}
                        className="file-input"
                    />
                </label>
            </div>
            <div className="form-block">
                <label htmlFor="previewFile" className="file-label">
                    Upload Video Preview
                    <input
                        type="file"
                        id="previewFile"
                        accept="image/*"
                        onChange={handlePreviewChange}
                        className="file-input"
                    />
                </label>
            </div>
            <button onClick={handleUpload} className="submit-button">
                Submit
            </button>
        </div>
    );
}

export default VideoUpload;

import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [jobDescription, setJobDescription] = useState('');
  const [resumeText, setResumeText] = useState('');
  const [result, setResult] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/rank', {
        jobDescription,
        resumeText
      });
      setResult(response.data);
    } catch (error) {
      setResult('Error: ' + error.message);
    }
  };

  return (
    <div style={{ maxWidth: '600px', margin: '50px auto', fontFamily: 'Arial' }}>
      <h2>AI Resume Ranker</h2>
      <form onSubmit={handleSubmit}>
        <label>Job Description</label><br />
        <textarea
          rows={6}
          style={{ width: '100%' }}
          placeholder="Paste Job Description"
          value={jobDescription}
          onChange={(e) => setJobDescription(e.target.value)}
        /><br /><br />

        <label>Resume Text</label><br />
        <textarea
          rows={6}
          style={{ width: '100%' }}
          placeholder="Paste Resume Text"
          value={resumeText}
          onChange={(e) => setResumeText(e.target.value)}
        /><br /><br />

        <button type="submit" style={{ padding: '10px 20px' }}>Rank Resume</button>
      </form>

      <div style={{ marginTop: '30px' }}>
        <h3>Result:</h3>
        <p>{result}</p>
      </div>
    </div>
  );
}

export default App;

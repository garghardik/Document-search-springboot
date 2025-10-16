import React, { useState } from "react";
import axios from "axios";

function DocumentSearch() {
    const [query, setQuery] = useState("");
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(false);

    const handleSearch = async () => {
        if (!query) {
            return;
        }
        setLoading(true);
        try {
            const response = await axios.get(`http://localhost:8080/api/document/search?q=${query}`);
            setData(response.data);
        } catch (error) {
            console.error("Error searching documents:", error);
        }
        setLoading(false);
    };

    return (
        <div style={styles.container}>
            <h2 style={styles.heading}>Document Search</h2>

            <div style={styles.searchBox}>
                <input
                    type="text"
                    value={query}
                    placeholder="Enter keyword..."
                    onChange={(e) => setQuery(e.target.value)}
                    style={styles.input}
                />
                <button onClick={handleSearch} style={styles.button}>
                    {loading ? "Searching..." : "Search"}
                </button>
            </div>

            <div style={styles.data}>
                {data.length === 0 && !loading ? (
                    <p style={styles.noData}>No results found</p>
                ) : (
                    <ul style={styles.list}>
                        {data.map((doc) => (
                            <li key={doc.id}>
                                <strong>{doc.title}</strong>: {doc.content}
                            </li>
                        ))}
                    </ul>
                )}
            </div>
        </div>
    );
}

const styles = {
    container: {
        maxWidth: "600px",
        margin: "30px auto",
        fontFamily: "Arial, sans-serif",
    },
    searchBox: {
        display: "flex",
        justifyContent: "center",
        marginBottom: "20px",
    },
    button: {
        padding: "8px 15px",
        borderRadius: "0 4px 4px 0",
        border: "1px solid #007BFF",
        backgroundColor: "#007BFF",
        color: "#fff",
        cursor: "pointer",
    },
    heading: {
        textAlign: "center",
        marginBottom: "20px",
    },
    data: {
        fontSize: "14px",
    },
    input: {
        width: "70%",
        padding: "8px",
        borderRadius: "4px 0 0 4px",
        border: "1px solid #ccc",
        fontSize: "14px",
    },
    list: {
        paddingLeft: "20px",
    },
    noData: {
        textAlign: "center",
        color: "#555",
        fontStyle: "italic",
    },
};

export default DocumentSearch;

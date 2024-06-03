document.getElementById('insertMouldForm').addEventListener('submit', insertMould);
document.getElementById('issueMouldForm').addEventListener('submit', issueMould);
document.getElementById('returnMouldForm').addEventListener('submit', returnMould);

async function insertMould(event) {
    event.preventDefault();

    const mould = {
        name: document.getElementById('name').value,
        manufacturer: document.getElementById('manufacturer').value,
        location: document.getElementById('location').value,
        totalProductions: document.getElementById('totalProductions').value,
        lastMaintenanceDate: document.getElementById('lastMaintenanceDate').value
    };

    try {
        const response = await fetch('/api/moulds', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(mould)
        });

        if (response.ok) {
            const result = await response.json();
            alert('Mould inserted successfully: ' + JSON.stringify(result));
        } else {
            alert('Failed to insert mould');
        }
    } catch (error) {
        alert('Error: ' + error);
    }
}

async function issueMould(event) {
    event.preventDefault();

    const mouldId = document.getElementById('issueMouldId').value;

    try {
        const response = await fetch(`/api/mouldUsages/issue/${mouldId}`, {
            method: 'POST',
        });

        if (response.ok) {
            const result = await response.json();
            alert('Mould issued successfully: ' + JSON.stringify(result));
        } else {
            alert('Failed to issue mould');
        }
    } catch (error) {
        alert('Error: ' + error);
    }
}

async function returnMould(event) {
    event.preventDefault();

    const logId = document.getElementById('logId').value;
    const productionsMade = document.getElementById('productionsMade').value;

    try {
        const response = await fetch(`/api/mouldUsages/${logId}/return?productionsMade=${productionsMade}`, {
            method: 'POST',
        });

        if (response.ok) {
            const result = await response.json();
            alert('Mould returned successfully: ' + JSON.stringify(result));
        } else {
            alert('Failed to return mould');
        }
    } catch (error) {
        alert('Error: ' + error);
    }
}

package Utilidades.tree;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/NodeMoveTransferHandler.class */
public class NodeMoveTransferHandler extends TransferHandler {
    private MutableTreeNode draggedNode;
    private TreePath dragPath;

    protected Transferable createTransferable(JComponent c) {
        Transferable t = null;
        if (c instanceof JTree) {
            JTree tree = (JTree) c;
            t = new GenericTransferable(tree.getSelectionPaths());
            this.dragPath = tree.getSelectionPath();
            if (this.dragPath != null) {
                this.draggedNode = (MutableTreeNode) this.dragPath.getLastPathComponent();
            }
        }
        return t;
    }

    protected void exportDone(JComponent source, Transferable data, int action) {
        if (source instanceof JTree) {
            JTree tree = (JTree) source;
            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
            TreePath currentPath = tree.getSelectionPath();
            if (currentPath != null) {
                addNodes(currentPath, model, data);
            } else {
                insertNodes(tree, model, data);
            }
        }
        this.draggedNode = null;
        super.exportDone(source, data, action);
    }

    private void addNodes(TreePath currentPath, DefaultTreeModel model, Transferable data) {
        MutableTreeNode targetNode = (MutableTreeNode) currentPath.getLastPathComponent();
        try {
            TreePath[] movedPaths = (TreePath[]) data.getTransferData(DataFlavor.stringFlavor);
            for (TreePath treePath : movedPaths) {
                MutableTreeNode moveNode = (MutableTreeNode) treePath.getLastPathComponent();
                if (!moveNode.equals(targetNode)) {
                    model.removeNodeFromParent(moveNode);
                    model.insertNodeInto(moveNode, targetNode, targetNode.getChildCount());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e2) {
            e2.printStackTrace();
        }
    }

    private void insertNodes(JTree tree, DefaultTreeModel model, Transferable data) {
        Point location = ((TreeDropTarget) tree.getDropTarget()).getMostRecentDragLocation();
        TreePath path = tree.getClosestPathForLocation(location.x, location.y);
        MutableTreeNode targetNode = (MutableTreeNode) path.getLastPathComponent();
        MutableTreeNode parent = targetNode.getParent();
        try {
            TreePath[] movedPaths = (TreePath[]) data.getTransferData(DataFlavor.stringFlavor);
            for (TreePath treePath : movedPaths) {
                MutableTreeNode moveNode = (MutableTreeNode) treePath.getLastPathComponent();
                if (!moveNode.equals(targetNode)) {
                    model.removeNodeFromParent(moveNode);
                    model.insertNodeInto(moveNode, parent, model.getIndexOfChild(parent, targetNode));
                }
            }
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public int getSourceActions(JComponent c) {
        return 2;
    }

    public BufferedImage getDragImage(JTree tree) {
        BufferedImage image = null;
        try {
            if (this.dragPath != null) {
                Rectangle pathBounds = tree.getPathBounds(this.dragPath);
                TreeCellRenderer r = tree.getCellRenderer();
                DefaultTreeModel m = tree.getModel();
                boolean nIsLeaf = m.isLeaf(this.dragPath.getLastPathComponent());
                JComponent lbl = r.getTreeCellRendererComponent(tree, this.draggedNode, false, tree.isExpanded(this.dragPath), nIsLeaf, 0, false);
                lbl.setBounds(pathBounds);
                image = new BufferedImage(lbl.getWidth(), lbl.getHeight(), 3);
                Graphics2D graphics = image.createGraphics();
                graphics.setComposite(AlphaComposite.getInstance(3, 0.5f));
                lbl.setOpaque(false);
                lbl.paint(graphics);
                graphics.dispose();
            }
        } catch (RuntimeException e) {
        }
        return image;
    }
}
